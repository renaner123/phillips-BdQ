import React, { useState, useEffect } from "react";
import axios from "axios";
import { config } from "../Constant";
import configHeader from "./ConfigHeader";

type PerformanceStudent = {
  setData: React.Dispatch<React.SetStateAction<any>>;
};

const QuestionsCount: React.FC<PerformanceStudent> = ({ setData }) => {
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get(`${config.url.BASE_URL}/students/performance`, configHeader);
        setData(response.data);
        setLoading(false);
      } catch (error) {
        console.error(error);
      }
    };
    fetchData();
  }, []);

  return (
    <>
    </>
  );
};

export default PerformanceStudent;
