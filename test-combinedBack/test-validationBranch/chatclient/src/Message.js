import React from 'react';

const Message = ({ message }) => {
  return (
    <div>
      <p>Sender: {message.sender.username}</p>
      <p>Content: {message.msg}</p>
    </div>
  );
};

export default Message;