import React from 'react';
import './EditPopup.css'; // Reuse the same styles as EditPopup

function DetailsPopup({ item, setShowDetailsPopup, activeTab }) {
    const renderDetails = () => {
        switch (activeTab) {
            case 'staff':
                return (
                    <>
                        <label>Name</label>
                        <p>{item.name}</p>
                        <label>Age</label>
                        <p>{item.age}</p>
                        <label>Password</label>
                        <p>{item.password}</p>
                    </>
                );
            case 'clients':
                return (
                    <>
                        <label>Name</label>
                        <p>{item.name}</p>
                        <label>Age</label>
                        <p>{item.age}</p>
                        <label>Trainer</label>
                        <p>{item.trainer ? item.trainer.name : 'N/A'}</p>
                    </>
                );
            case 'trainers':
                return (
                    <>
                        <label>Name</label>
                        <p>{item.name}</p>
                    </>
                );
            default:
                return null;
        }
    };

    return (
        <div className="edit-popup">
            <div className="edit-popup-content">
                <h3>Details</h3>
                {renderDetails()}
                <button onClick={() => setShowDetailsPopup(false)}>Close</button>
            </div>
        </div>
    );
}

export default DetailsPopup;
