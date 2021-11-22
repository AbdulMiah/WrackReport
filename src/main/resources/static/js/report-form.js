const description = document.getElementById('description');
const remainingCharsText = document.getElementById('remaining-chars');
const MAX_Chars = 2500;

if(description != null){

   description.addEventListener('input',() => {
      const remaining = MAX_Chars - description.value.length;
      remainingCharsText.textContent = `${remaining} Characters Remaining`
   });

}
else{
   console.log("doesnt work")
}
