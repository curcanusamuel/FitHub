import React from 'react';
import './TrainerClientsPopup.css';

function TrainerClientsPopup({ clients, setShowTrainerClientsPopup }) {
    return (
        <div className="trainer-clients-popup">
            <div className="trainer-clients-popup-content">
                <h3>Trainer's Clients</h3>
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
                <button onClick={() => setShowTrainerClientsPopup(false)}>Close</button>
            </div>
        </div>
    );
}

export default TrainerClientsPopup;
