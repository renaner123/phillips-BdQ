import React from "react";
import { Outlet } from "react-router-dom";
//import "../styleSheet/home.css";

interface Props {
  numQuestions: number;
  numMaterials: number;
}


const Home: React.FC<Props> = ({ numQuestions, numMaterials }) => {
  return (
    <div className="home-container">
      <h1>Welcome to database Questions!</h1>
      <p className="home-text">
        There are {numQuestions} questions in the database.
      </p>
      <p className="home-text">
        There are {numMaterials} Materials in the database.
      </p>
      <Outlet/>
    </div>
  );
};

export default Home;