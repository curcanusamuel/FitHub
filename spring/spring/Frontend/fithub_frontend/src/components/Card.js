import React from 'react';
import './Card.css';

function Card({ item, handleClick, handleEditClick, handleDelete, handleTrainerClients, activeTab }) {
    return (
        <div className="card" onClick={() => handleClick(item)}>
            <div className="card-content">
                <p>{item.name}</p>
                <div className="card-buttons">
                    <button onClick={(e) => { e.stopPropagation(); handleEditClick(item); }}>✏️</button>
                    <button onClick={(e) => { e.stopPropagation(); handleDelete(item.id); }}>🗑️</button>
                    {activeTab === 'trainers' && (
                        <button onClick={(e) => { e.stopPropagation(); handleTrainerClients(item); }}>👥</button>
                    )}
                </div>
            </div>
        </div>
    );
}

export default Card;
