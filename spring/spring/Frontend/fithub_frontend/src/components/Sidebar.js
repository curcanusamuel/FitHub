import React from 'react';
import './Sidebar.css';

function Sidebar({ activeTab, setActiveTab }) {
    const tabs = ['staff', 'clients', 'trainers'];

    return (
        <div className="sidebar">
            <div className="tab-buttons">
                {tabs.map(tab => (
                    <button 
                        key={tab} 
                        className={activeTab === tab ? 'selected' : ''} 
                        onClick={() => setActiveTab(tab)}
                    >
                        {tab.charAt(0).toUpperCase() + tab.slice(1)}
                    </button>
                ))}
            </div>
        </div>
    );
}

export default Sidebar;
