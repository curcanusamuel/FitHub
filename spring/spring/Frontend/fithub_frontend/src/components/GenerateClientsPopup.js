import React, { useState } from 'react';
import './GenerateClientsPopup.css';

function GenerateClientsPopup({ setShowGenerateClientsPopup, handleGenerateClients }) {
    const [count, setCount] = useState('');

    const handleSubmit = () => {
        handleGenerateClients(Number(count));
        setShowGenerateClientsPopup(false);
    };

    return (
        <div className="generate-clients-popup">
            <div className="generate-clients-popup-content">
                <h3>Generate Clients</h3>
                <label>Number of Clients:</label>
                <input 
                    type="number" 
                    value={count} 
                    onChange={(e) => setCount(e.target.value)} 
                    min="1"
                />
                <button onClick={handleSubmit}>Generate</button>
                <button onClick={() => setShowGenerateClientsPopup(false)}>Cancel</button>
            </div>
        </div>
    );
}

export default GenerateClientsPopup;
