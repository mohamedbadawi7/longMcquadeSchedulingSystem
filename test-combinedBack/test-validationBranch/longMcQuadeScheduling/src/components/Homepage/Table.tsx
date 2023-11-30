import Table from "react-bootstrap/Table";

/* Tables to display lesson information on the homepage */
const Tables = () => {
  const headings = [
    "Student",
    "Teacher",
    "Date",
    "Time",
    "Instrument",
    "Room",
    "Location",
  ];

  // glpat-me9NJE6WL-Jy_nDq9iP-

  const lessons = [
    "Rhapsody Ruth",
    "Jana Janovsky",
    "Wednesday, October 25",
    "3:30pm",
    "Violin",
    "Room",
    "Saskatoon North",
  ];
  // fetch("http://localhost:1919/users/students/")

  const style = {
    width: "8rem",
    backgroundColor: "#F5F1ED",
    fontFamily: "Raleway",
    fontSize: "14px",
  };

  //   TODO: insert lesson information below.. hardcoded for now

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
    
    // for (const key in reponseData) {
    //   loadedBooks.push{
    //     id: responseData[key].id,
    //     title: responseData[key].title,

    //   }
    // }
  }

  return (
    <Table responsive hover bordered size="sm">
      <thead>
        <tr id="row">
          {headings.map((heading) => (
            <th style={style} key={heading}>
              {heading}
            </th>
          ))}
        </tr>
      </thead>
      <tbody>
        <tr id="row">
          {lessons.map((lesson) => (
            <td key={lesson} style={style}>
              {lesson}
            </td>
          ))}
        </tr>
        <tr id="row">
          {lessons.map((lesson) => (
            <td key={lesson} style={style}>
              {lesson}
            </td>
          ))}
        </tr>
      </tbody>
    </Table>
  );
};

export default Tables;
