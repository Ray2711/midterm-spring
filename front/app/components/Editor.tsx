'use client'
import { useState } from 'react';
import { useForm } from 'react-hook-form'

export default function Editor() {
    const { register, handleSubmit } = useForm();
    const [count, setCount] = useState(0);
    const login = async (data: any) => {
        fetch(`http://localhost:8080/api/v1/customers`, {
            method: "POST",
            body: JSON.stringify({
                email: data.email,
                name: data.name,
                age:data.age,
            }),
            headers: {
                "Content-type": "application/json; charset=UTF-8"
            }
        })
        
    }
    return (
        <form action="" className="accent w-3/12 h-full text-white p-5" onSubmit={handleSubmit(login)}>
        <div className=" flex flex-col justify-between">
          <div className="mt-24 h-1/5 flex flex-col justify-between">
            <input type="text"  id="name" placeholder="Name"  {...register('name')}/>
            <input type="text"  id="email" placeholder="Email" {...register('email')}/>
            <input type="text"  id="age" placeholder="Age" {...register('age')}/>
          </div>
  
          <button type="submit" className="w-30 p-5 secondary hover:bg-teal-900 text-5xl"> OK </button>
        </div>
        </form>
      )
  }