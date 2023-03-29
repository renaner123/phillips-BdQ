import React, { useState, useEffect } from "react";
import axios from "axios";
import configHeader from "./ConfigHeader";
import { config } from "../Constant";

type MaterialsCount = {
  setData: React.Dispatch<React.SetStateAction<any>>;
};

const QuestionsCount: React.FC<MaterialsCount> = ({ setData }) => {
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get(`${config.url.BASE_URL}/materials/count`, configHeader);
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
