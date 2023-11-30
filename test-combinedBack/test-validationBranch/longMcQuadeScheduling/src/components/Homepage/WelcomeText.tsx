import React, { useState, useEffect } from 'react';

const WelcomeText = () => {
  const [name, setName] = useState('');

  console.log("hello")
  useEffect(() => {
    // Make a GET request to your Spring Boot API endpoint
    fetch('http://localhost:1919/users/students/s')
        .then(response => response.json())
        .then(data => {
          setName(data.name);
          console.log(data)
        })
        .catch(error => console.error('Error:', error));
  }, []);

  const style = {
    fontFamily: "Roboto",
    color: "#080F0F",
    fontWeight: "500",
    fontSize: "45px",
    width: "fit-content",
    height: "fit-content",
    paddingBottom: "1rem",
    borderBottom: "5px solid #F68B1F",
    borderImage: "linear-gradient(to right, #f5f1ed, #f68b1f) 1",
  };

  const fetchBooks =async () => {
    
    const baseUrl: string = "http://localhost:1919/users/students/";

    const url: string = `${baseUrl}?page=0&size=9`;

    const response = await fetch(url);

    if (!reponse.ok) {
      throw new Error('Something went wrong!');
    }

    const reponseJson = await reponse.json();

    const reponseData = responseJson.students;

    const loadedStudents: StudentModel[] = [];

    console.log(reponseData)
  }
  fetchBooks().catch((error:any) => {

    console.log("error");
  })

  if (name) {
    return (
      <h1 className="display-1" style={style}>
        Welcome {name}
      </h1>
    );
  }
  return (
    <h1 className="display-1" style={style}>
      Welcome
    </h1>
  );
};

export default WelcomeText;
