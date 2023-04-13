import React, { useEffect, useState } from 'react';
import { useAPI } from '../services/Api';
import '../styleSheet/top-materials.scss'; 

interface Subject {
  idDscipline: number;
  description: string;
  amountAccess: number;
}

interface Material {
  id: number;
  fileName: string;
  uploadDate: Date,
  idClient: number,
  docType: string,
  amountAccess: number,
  tag: string,
  certified: boolean
}

function TopSubjects() {
  const [subjects, setSubjects] = useState<Subject[]>([]);
  const [materials, setMaterials] = useState<Material[]>([]);

  const api = useAPI();  

  const getMaterials = () => {
    api.get('/materials/amount-access', {}).then((res: React.SetStateAction<Material[]>) => {
       setMaterials(res);;
    })
  };

  useEffect(() => {
    api.get('/subjects/amount-access', {}).then((res: React.SetStateAction<Subject[]>) => {
        getMaterials();
        setSubjects(res);
    })
  }, [])

  return (
    <div>
      <div className="top-materials"> {/* adicione a classe aqui */}
        <h1 className="h2 text-center pb-3">Top 5 Subjects Mais Acessados</h1>
        <ol>
          {subjects.slice(0, 5).map((subject) => (
            <li key={subject.idDscipline+subject.description}>
              <strong>{subject.description}</strong> - <span className="views">{subject.amountAccess} views</span>
            </li>
          ))}
        </ol>
      </div>

      <div className="top-materials"> {/* adicione a classe aqui */}
      <h1 className="h2 text-center pb-3">Top 5 Materials Mais Acessados</h1>
      <ol>
        {materials.slice(0, 5).map((material) => (
          <li key={material.id+material.fileName}>
            <strong>{material.fileName}</strong> - <span className="views">{material.amountAccess} views</span>
          </li>
        ))}
      </ol>
    </div>
  </div>
  );  
}


export default TopSubjects;
