import React from "react";
import "../styleSheet/home.css";

interface Props {
  numQuestions: number;
}


const Home: React.FC<Props> = ({ numQuestions }) => {
  return (
    <div className="home-container">
      <h1>Welcome to database Questions!</h1>
      <p className="home-text">
        There are {numQuestions} questions in the database.
      </p>
      <p className="home-text">
        There are {numQuestions} Materials in the database.
      </p>
    </div>
  );
};

export default Home;