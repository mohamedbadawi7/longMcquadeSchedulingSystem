interface ButtonProps {
  children: string;
  color: string;
  onClick: () => void;
}

const Button = ({ children, onClick, color }: ButtonProps) => {
  return (
    <button
      style={{
        height: "fit-content",
        padding: "5px 10px 5px 10px",
        fontFamily: "Raleway",
        fontSize: "14px",
        margin: "2rem 0 0.5rem 0",
      }}
      className={"btn btn-" + color}
      onClick={onClick}
    >
      {children}
    </button>
  );
};

export default Button;
