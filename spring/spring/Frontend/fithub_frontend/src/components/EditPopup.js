import React, { useEffect } from 'react';

function EditPopup({ activeTab, editItem, setEditItem, setShowEditPopup, handleSave, allTrainers, isAdding }) {
    useEffect(() => {
        if (activeTab === 'clients' && editItem.trainer && !allTrainers.find(trainer => trainer.id === editItem.trainer.id)) {
            setEditItem({ ...editItem, trainer: null });
        }
    }, [allTrainers]);

    const handleInputChange = (key, value) => {
        setEditItem({ ...editItem, [key]: value });
    };

    const handleTrainerChange = (trainerId) => {
        const selectedTrainer = allTrainers.find(trainer => trainer.id === parseInt(trainerId, 10)) || null;
        setEditItem({ ...editItem, trainer: selectedTrainer });
    };

    return (
        <div className="edit-popup">
            <div className="edit-popup-content">
                <h3>{isAdding ? `Add New ${activeTab.slice(0, -1)}` : `Edit ${activeTab.slice(0, -1)}`}</h3>
                {Object.keys(editItem).map(key => (
                    <div key={key}>
                        {key !== 'id' && (
                            <>
                                <label>{key}</label>
                                {key === 'trainer' && activeTab === 'clients' ? (
                                    <>
                                        <input type="checkbox" 
                                            checked={!!editItem.trainer} 
                                            onChange={(e) => handleTrainerChange(e.target.checked ? allTrainers[0]?.id : null)} 
                                        />
                                        {editItem.trainer && (
                                            <select 
                                                value={editItem.trainer?.id || ''} 
                                                onChange={(e) => handleTrainerChange(e.target.value)}>
                                                <option value="">Select a trainer</option>
                                                {allTrainers.map(trainer => (
                                                    <option key={trainer.id} value={trainer.id}>
                                                        {trainer.name}
                                                    </option>
                                                ))}
                                            </select>
                                        )}
                                    </>
                                ) : (
                                    <input 
                                        type="text" 
                                        value={editItem[key] || ''} 
                                        onChange={(e) => handleInputChange(key, e.target.value)} 
                                    />
                                )}
                            </>
                        )}
                    </div>
                ))}
                <button onClick={handleSave}>Save</button>
                <button onClick={() => setShowEditPopup(false)}>Cancel</button>
            </div>
        </div>
    );
}

export default EditPopup;
