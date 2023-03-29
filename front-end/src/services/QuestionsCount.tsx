import React, { useState, useEffect } from "react";
import axios from "axios";
import configHeader from "./ConfigHeader";
import { config } from "../Constant";

type QuestionsCountProps = {
  setData: React.Dispatch<React.SetStateAction<any>>;
};

const QuestionsCount: React.FC<QuestionsCountProps> = ({ setData }) => {
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get(`${config.url.BASE_URL}/questions/count`, configHeader);
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
