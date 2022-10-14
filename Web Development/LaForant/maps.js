$(function(){
    var maps = $('.map')
    maps.hide()
  
    var currIdx = 0;
    var minIdx = 0;
    var maxIdx = maps.length - 1
  
    maps.eq(currIdx).show()
  
    $('#slide-left').click(()=>{
      maps.eq(currIdx).hide()
      currIdx -= 1
      if(currIdx < minIdx){
        currIdx = maxIdx
      }
      maps.eq(currIdx).fadeIn()
    })
  
    $('#slide-right').click(()=>{
      maps.eq(currIdx).hide()
      currIdx += 1
      if(currIdx > maxIdx){
        currIdx = minIdx
      }
      maps.eq(currIdx).fadeIn()
    })
  })