import React, { useState, useEffect } from "react";
import axios from "axios";

type QuestionsCountProps = {
  setData: React.Dispatch<React.SetStateAction<any>>;
};

const config = {
  headers: {
    'Content-Type': 'application/json',
    Authorization: `Basic ${btoa(`${'renan'}:${'123'}`)}`,
    Accept: 'application/json',
  }
};
const QuestionsCount: React.FC<QuestionsCountProps> = ({ setData }) => {
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get("http://127.0.0.1:8080/questions/count", config);
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