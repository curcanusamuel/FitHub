import React, { useState } from 'react';
import './Login.css'; // Importă fișierul CSS pentru stilizare
import ManagerAccount from './ManagerAccount';
import logo from './fithub_logo.png'; // Importă imaginea de logo

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');
  const [notification, setNotification] = useState('');
  const [isLoggingIn, setIsLoggingIn] = useState(false);
  const [isLoggedIn, setIsLoggedIn] = useState(false); // Stare pentru a verifica dacă utilizatorul este autentificat

  const handleLogin = (event) => {
    event.preventDefault(); // Previne trimiterea formularului

    setIsLoggingIn(true); // Setează starea pentru animație

    // Trimite o cerere pentru a verifica numele de utilizator și parola
    fetch("http://localhost:8080/api/staffs/login", {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({ username, password })
    })
      .then(response => {
        setIsLoggingIn(false); // Oprește animația după primirea răspunsului
        if (!response.ok) {
          throw new Error('Incorrect username or password');
        }
        setIsLoggedIn(true); // Marchează utilizatorul ca autentificat
      })
      .catch(error => {
        setIsLoggingIn(false); // Oprește animația în caz de eroare
        setNotification(error.message); // Afișează mesajul de eroare
      });
  };

  // Dacă utilizatorul este autentificat, afișează pagina ManagerAccount
  if (isLoggedIn) {
    return <ManagerAccount />;
  }

  // Dacă utilizatorul nu este autentificat, afișează formularul de autentificare
  return (
    <div className="login-container">
      <img src={logo} alt="Logo" className="logo" /> {/* Adaugă logo-ul */}
      <form onSubmit={handleLogin}>
        <label>
          Username:
          <input type="text" value={username} onChange={e => setUsername(e.target.value)} />
        </label>
        <br />
        <label>
          Password:
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
        </label>
        <br />
        <button type="submit" className={`login-button ${isLoggingIn ? 'logging-in' : ''}`}>
          {isLoggingIn ? 'Logging in...' : 'Login'}
        </button>
      </form>
      <div className="notification">{notification}</div>
    </div>
  );
}

export default Login;
