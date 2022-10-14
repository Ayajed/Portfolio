$(function(){
    var agents = $('.agent')
    agents.hide()
  
    var currIdx = 0;
    var minIdx = 0;
    var maxIdx = agents.length - 1
  
    agents.eq(currIdx).show()
  
    $('#slide-left').click(()=>{
      agents.eq(currIdx).hide()
      currIdx -= 1
      if(currIdx < minIdx){
        currIdx = maxIdx
      }
      agents.eq(currIdx).fadeIn()
    })
  
    $('#slide-right').click(()=>{
      agents.eq(currIdx).hide()
      currIdx += 1
      if(currIdx > maxIdx){
        currIdx = minIdx
      }
      agents.eq(currIdx).fadeIn()
    })
  })