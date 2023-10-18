export default function SideBar() {
    return (
      <div className="primary w-3/12 h-full text-white p-5 flex flex-col justify-between">
        <div>
        <h1 className="font-bold text-5xl"> CUSTOMATHON</h1>

        <h2 className="text-2xl"> Serving <span className="font-bold">{3}</span> customers</h2>
        </div>

        <button type="button" className="w-30 p-9 secondary hover:bg-teal-900"> + </button>
      </div>
    )
}