import React from 'react';
import './ClientsWithoutTrainersPopup.css';

function ClientsWithoutTrainersPopup({ clients, setShowClientsWithoutTrainersPopup }) {
    return (
        <div className="clients-without-trainers-popup">
            <div className="clients-without-trainers-popup-content">
                <h3>Clients Without Trainers</h3>
                <div className="clients-list">
                    <table>
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Age</th>
                            </tr>
                        </thead>
                        <tbody>
                            {clients.map((client, index) => (
                                <tr key={index}>
                                    <td>{client.name}</td>
                                    <td>{client.age}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
                <button onClick={() => setShowClientsWithoutTrainersPopup(false)}>Close</button>
            </div>
        </div>
    );
}

export default ClientsWithoutTrainersPopup;
