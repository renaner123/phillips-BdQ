import React, { useState, useEffect } from "react";
import axios from "axios";
import configHeader from "./ConfigHeader";

type MaterialsCount = {
  setData: React.Dispatch<React.SetStateAction<any>>;
};

const QuestionsCount: React.FC<MaterialsCount> = ({ setData }) => {
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get("http://127.0.0.1:8080/materials/count", configHeader);
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

export default QuestionsCount;
