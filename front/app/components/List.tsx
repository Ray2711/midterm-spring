'use client'
import { useState, useEffect } from 'react'
export default  function List() {
    const [data, setData] = useState([{}])
    //const data = await getItems();

    useEffect(() => {
        const interval = setInterval(() => {
          fetch(`http://localhost:8080/api/v1/customers`, { cache: 'no-store' })
            .then(res => res.json())
            .then(data => {setData(data);});
        }, 1000);
        
        return () => clearInterval(interval);
      }, []);
    return (
        <div className="secondary w-1/2 h-full text-white overflow-y-auto">
            {data.map(item=>(
                <ListItem {...item}></ListItem>
            ))}
        </div>
    )
}

function removeItem(id:any){
    fetch(`http://localhost:8080/api/v1/customers/${id}`, { method:'DELETE', cache: 'no-store' })
}

function ListItem({ name, email, age, id   }: any){
    return (
        <div className="h-24 border-b-teal-900 border-b flex items-center">
            <div className="flex flex-row items-center justify-between w-4/5 m-auto">
                <div>
                    <h1 className="text-3xl font-bold">{name}</h1>
                    <h2>{email} </h2>
                </div>
                <div>
                    <h2 className="text-3xl font-bold"> {age}</h2>
                    <button type="button" className="bg-rose-800 w-8 h-8" onClick={()=>{removeItem(id)}}>-</button>
                </div>
            </div>


        </div>
    )
}