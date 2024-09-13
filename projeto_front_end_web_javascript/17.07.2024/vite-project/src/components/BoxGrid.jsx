import ContentBox from "./ContentBox";
import PropTypes from "prop-types";

function BoxGrid({infoBoxes}) {
   
    return (
        <div className='boxGrid'>
            {infoBoxes.map(item => <ContentBox key={item.id} info={item.nome}/>)}
       </div>
    )
}

BoxGrid.propTypes = {
    infoBoxes: PropTypes.array
}

export default BoxGrid;