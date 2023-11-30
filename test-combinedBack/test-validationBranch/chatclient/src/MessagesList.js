import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Message from './Message';
import './MessagesList.css';

const MessagesList = () => {
  const [messages, setMessages] = useState([]);
  const [userId, setUserId] = useState(null); // Use state to store user id

  useEffect(() => {
    // Simulate user authentication and get the user id
    const fakeAuthentication = () => {
      // Replace this logic with your actual authentication mechanism
      const storedUserId = localStorage.getItem('userId');
      if (storedUserId) {
        setUserId(storedUserId);
      } else {
        // If user is not authenticated
      }
    };

    fakeAuthentication();

    // Fetch messages when the component mounts
    if (userId) {
      axios.get(`http://localhost:8080/messages/for/${userId}`)
        .then(response => setMessages(response.data))
        .catch(error => console.error('Error fetching messages:', error));
    }
  }, [userId]); // Only fetch messages when userId changes

  return (
    <div>
      <h2>Messages List</h2>
      {messages.map(message => (
        <Message key={message.id} message={message} />
      ))}
    </div>
  );
};

export default MessagesList;