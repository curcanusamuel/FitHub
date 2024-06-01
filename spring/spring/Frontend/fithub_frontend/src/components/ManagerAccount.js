import React, { useState, useEffect } from 'react';
import './ManagerAccount.css';
import logo from './fithub_logo.png';
import Sidebar from './Sidebar';
import Content from './Content';
import EditPopup from './EditPopup';
import DetailsPopup from './DetailsPopup';
import TrainerClientsPopup from './TrainerClientsPopup';
import ClientsWithoutTrainersPopup from './ClientsWithoutTrainersPopup';
import GenerateClientsPopup from './GenerateClientsPopup';

function ManagerAccount() {
    const [trainers, setTrainers] = useState([]);
    const [clients, setClients] = useState([]);
    const [staff, setStaff] = useState([]);
    const [activeTab, setActiveTab] = useState(null);
    const [editItem, setEditItem] = useState(null);
    const [showEditPopup, setShowEditPopup] = useState(false);
    const [showTrainerClientsPopup, setShowTrainerClientsPopup] = useState(false);
    const [trainerClients, setTrainerClients] = useState([]);
    const [isAdding, setIsAdding] = useState(false);
    const [allTrainers, setAllTrainers] = useState([]);
    const [showDetailsPopup, setShowDetailsPopup] = useState(false);
    const [detailsItem, setDetailsItem] = useState(null);
    const [showClientsWithoutTrainersPopup, setShowClientsWithoutTrainersPopup] = useState(false);
    const [clientsWithoutTrainers, setClientsWithoutTrainers] = useState([]);
    const [showGenerateClientsPopup, setShowGenerateClientsPopup] = useState(false);

    useEffect(() => {
        fetch("http://localhost:8080/api/trainers")
            .then(response => response.json())
            .then(data => {
                setTrainers(data);
                setAllTrainers(data);
            })
            .catch(error => console.error('Error fetching trainers:', error));

        fetch("http://localhost:8080/api/clients")
            .then(response => response.json())
            .then(data => {
                setClients(data);
            })
            .catch(error => console.error('Error fetching clients:', error));

        fetch("http://localhost:8080/api/staffs")
            .then(response => response.json())
            .then(data => {
                setStaff(data);
            })
            .catch(error => console.error('Error fetching staff:', error));
    }, []);

    const handleEditClick = (item) => {
        setEditItem(item);
        setShowEditPopup(true);
        setIsAdding(false);
    };

    const handleAddClick = () => {
        const newItem = activeTab === 'clients'
            ? { name: '', age: '', trainer: null }
            : activeTab === 'trainers'
                ? { name: '' }
                : { name: '', age: '', password: '' };

        setEditItem(newItem);
        setShowEditPopup(true);
        setIsAdding(true);
    };

    const handleSave = () => {
        const url = activeTab === 'clients'
            ? `http://localhost:8080/api/clients`
            : activeTab === 'trainers'
                ? `http://localhost:8080/api/trainers`
                : `http://localhost:8080/api/staffs`;
        const method = isAdding ? 'POST' : 'PUT';

        const payload = {
            ...editItem,
            trainer: editItem.trainer ? { id: editItem.trainer.id } : null
        };

        fetch(`${url}${isAdding ? '' : `/${editItem.id}`}`, {
            method,
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        })
        .then(response => response.json())
        .then(data => {
            setShowEditPopup(false);
            if (activeTab === 'clients') {
                const updatedClients = isAdding ? [...clients, data] : clients.map(client => client.id === data.id ? data : client);
                setClients(updatedClients);
            } else if (activeTab === 'trainers') {
                const updatedTrainers = isAdding ? [...trainers, data] : trainers.map(trainer => trainer.id === data.id ? data : trainer);
                setTrainers(updatedTrainers);
                setAllTrainers(updatedTrainers);
            } else {
                const updatedStaff = isAdding ? [...staff, data] : staff.map(staffMember => staffMember.id === data.id ? data : staffMember);
                setStaff(updatedStaff);
            }
        })
        .catch(error => console.error('Error saving item:', error));
    };

    const handleDelete = (id) => {
        const url = activeTab === 'clients'
            ? `http://localhost:8080/api/clients/${id}`
            : activeTab === 'trainers'
                ? `http://localhost:8080/api/trainers/${id}`
                : `http://localhost:8080/api/staffs/${id}`;

        fetch(url, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                if (activeTab === 'clients') {
                    setClients(clients.filter(client => client.id !== id));
                } else if (activeTab === 'trainers') {
                    setTrainers(trainers.filter(trainer => trainer.id !== id));
                    setAllTrainers(trainers.filter(trainer => trainer.id !== id));
                    // Update clients to set trainer to null
                    const updatedClients = clients.map(client => 
                        client.trainer && client.trainer.id === id ? { ...client, trainer: null } : client
                    );
                    setClients(updatedClients);
                } else {
                    setStaff(staff.filter(staffMember => staffMember.id !== id));
                }
            } else {
                console.error('Error deleting item:', response);
            }
        })
        .catch(error => console.error('Error deleting item:', error));
    };

    const handleTrainerClients = (trainer) => {
        setTrainerClients(clients.filter(client => client.trainer && client.trainer.id === trainer.id));
        setShowTrainerClientsPopup(true);
    };

    const handleCardClick = (item) => {
        setDetailsItem(item);
        setShowDetailsPopup(true);
    };

    const handleShowClientsWithoutTrainers = () => {
        setClientsWithoutTrainers(clients.filter(client => !client.trainer));
        setShowClientsWithoutTrainersPopup(true);
    };

    const handleGenerateClients = (count) => {
        fetch(`http://localhost:8080/api/clients/generate?count=${count}`, {
            method: 'POST'
        })
        .then(response => response.json())
        .then(data => {
            setClients([...clients, ...data]);
        })
        .catch(error => console.error('Error generating random clients:', error));
    };

    const handleDeleteAllClients = () => {
        fetch('http://localhost:8080/api/clients/deleteAll', {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                setClients([]);
            } else {
                console.error('Error deleting all clients:', response);
            }
        })
        .catch(error => console.error('Error deleting all clients:', error));
    };

    return (
        <div className="manager-account">
            <div className="top-bar">
                <img src={logo} alt="FitHub Logo" />
            </div>
            <div className="main-content">
                <Sidebar activeTab={activeTab} setActiveTab={setActiveTab} />
                <Content 
                    activeTab={activeTab} 
                    trainers={trainers} 
                    clients={clients} 
                    staff={staff} 
                    handleEditClick={handleEditClick} 
                    handleDelete={handleDelete} 
                    handleTrainerClients={handleTrainerClients}
                    handleCardClick={handleCardClick}
                />
            </div>
            {activeTab === 'clients' && (
                <div className="bottom-buttons">
                    <button className="show-clients-without-trainers-button" onClick={handleShowClientsWithoutTrainers}>
                        Show Clients Without Trainers
                    </button>
                    <button className="generate-random-clients-button" onClick={() => setShowGenerateClientsPopup(true)}>
                        Generate Clients
                    </button>
                    <button className="delete-all-clients-button" onClick={handleDeleteAllClients}>
                        Delete All Clients
                    </button>
                </div>
            )}
            <button className="add-button" onClick={handleAddClick}>
                +
            </button>
            {showEditPopup && (
                <EditPopup 
                    activeTab={activeTab} 
                    editItem={editItem} 
                    setEditItem={setEditItem} 
                    setShowEditPopup={setShowEditPopup} 
                    handleSave={handleSave} 
                    allTrainers={allTrainers} 
                    isAdding={isAdding}
                />
            )}
            {showDetailsPopup && (
                <DetailsPopup 
                    item={detailsItem} 
                    setShowDetailsPopup={setShowDetailsPopup} 
                    activeTab={activeTab}
                />
            )}
            {showTrainerClientsPopup && (
                <TrainerClientsPopup 
                    clients={trainerClients} 
                    setShowTrainerClientsPopup={setShowTrainerClientsPopup} 
                />
            )}
            {showClientsWithoutTrainersPopup && (
                <ClientsWithoutTrainersPopup 
                    clients={clientsWithoutTrainers} 
                    setShowClientsWithoutTrainersPopup={setShowClientsWithoutTrainersPopup} 
                />
            )}
            {showGenerateClientsPopup && (
                <GenerateClientsPopup 
                    setShowGenerateClientsPopup={setShowGenerateClientsPopup} 
                    handleGenerateClients={handleGenerateClients}
                />
            )}
        </div>
    );
}

export default ManagerAccount;
