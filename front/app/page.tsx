import Image from 'next/image'
import Sidebar from './components/Sidebar'
import List from './components/List'
import Editor from './components/Editor'

export default function Home() {
  return (
    <div className='flex flex-row w-full h-screen'>
      <Sidebar></Sidebar>
      <List></List>
      <Editor></Editor>
    </div>
  )
}
