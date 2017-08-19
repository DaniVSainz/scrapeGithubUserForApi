document.querySelector('rect[data-count]').dataset.count
document.querySelectorAll('rect[data-count]')

for (i=0;i<elem.length;i++){
    console.log(elem[i].dataset.count)
  }

  	public void getFirstCommitDate() throws InterruptedException {
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String makeElem = 
				  "elem=document.querySelector('rect[data-count]').getAttribute('data-count')";
	
		js.executeScript(makeElem).toString();
		String getCount=
				"return for (i=0;i<elem.length;i++) { console.log(elem[i].dataset.count)}";
		System.out.println(js.executeScript(getCount));
  }
  
   "var elem=document.querySelectorAll('rect[data-count]');return for (i=0;i<elem.length;i++) { console.log(elem[i].dataset.count)}";

   "var elem=document.querySelectorAll('rect[data-count]');var asd=[];  for (i=0;i<elem.length;i++) { asd[i]=elem[i].dataset.count}"