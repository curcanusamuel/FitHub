import React from 'react';
import Card from './Card';
import './Content.css';

function Content({ activeTab, trainers, clients, staff, handleEditClick, handleDelete, handleTrainerClients, handleCardClick }) {
    const renderCards = (data) => {
        if (data.length === 0) return <p>No data available</p>;

        return data.map((item, index) => (
            <Card 
                key={index} 
                item={item} 
                handleClick={handleCardClick} 
                handleEditClick={handleEditClick} 
                handleDelete={handleDelete} 
                handleTrainerClients={handleTrainerClients}
                activeTab={activeTab}
            />
        ));
    };

    return (
        <div className="content">
            <div className={`card-container ${activeTab === 'staff' ? 'active' : ''}`}>
                {activeTab === 'staff' && renderCards(staff)}
            </div>
            <div className={`card-container ${activeTab === 'clients' ? 'active' : ''}`}>
                {activeTab === 'clients' && renderCards(clients)}
            </div>
            <div className={`card-container ${activeTab === 'trainers' ? 'active' : ''}`}>
                {activeTab === 'trainers' && renderCards(trainers)}
            </div>
        </div>
    );
}

export default Content;
