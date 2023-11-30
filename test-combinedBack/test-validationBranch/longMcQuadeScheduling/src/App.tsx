import "./App.css";
import Header from "./components/Header";
import Navbar from "./components/Navbar";
import Welcome from "./components/Homepage/WelcomeText";
import Table from "./components/Homepage/Table";
import Button from "./components/Button";

/* 
  The main application for all components 
  TODO: need to make all pages responsive.
*/
function App() {
  return (
    <>
      <div id="appContainer">
        <Header></Header>
        <Navbar></Navbar>
        <div id="homepage">
          <Welcome></Welcome>
          <h2 id="tableHeading">Upcoming Lessons</h2>
          <Table></Table>
          <div id="lessonChangeRequestHeader">
            <h2 id="tableHeading">Lesson Change Requests</h2>
            <Button color="dark" onClick={() => console.log("Clicked")}>
              Request Change
            </Button>
          </div>
          <Table></Table>
        </div>
      </div>
    </>
  );
}

export default App;
