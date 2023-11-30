import wordLogo from "../assets/logo-words.png";
import messageIcon from "../assets/995789_comment_communication_message_messages_icon.svg";
import phoneIcon from "../assets/9023670_phone_call_fill_icon.svg";
import "./Header.css";

/* 
  Topbar is the section at the top of the screen where the logo, message icon, contact icon, and sign out option
  live. Has it's own css file for styling.
  TODO: fix hover on icons - try to fix padding issue.
 */
const Top = () => {
  return (
    <nav
      id="topContainer"
      className="navbar fixed-top navbar-light bg-background"
    >
      <a className="navbar-brand" href="#">
        <img
          src={wordLogo}
          id="wordLogo"
          width="180px"
          className="d-inline-block align-top"
          alt=""
        />
      </a>
      <div id="rightmostLinks">
        <div id="iconsTop">
          <a id="iconLink" href="/#">
            <img src={messageIcon} width="30px" alt="Message Icon" />
          </a>
          <a id="iconLink" href="/#">
            <img src={phoneIcon} width="30px" alt="Phone Icon" />
          </a>
        </div>
        <div id="wordLinks">
          <a id="signOut" href="/#">
            Sign Out
          </a>
          <a id="reportProblem" href="/#">
            Report a Problem
          </a>
        </div>
      </div>
    </nav>
  );
};

export default Top;
