import ContentBox from "./ContentBox";

function BoxGrid({infoBoxes}) {
   
    return (
        <div className='boxGrid'>
            {infoBoxes.map(item => <ContentBox key={item.id} info={item.nome}/>)}
       </div>
    )
}

export default BoxGrid;