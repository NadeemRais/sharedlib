//   def version = readFile('VERSION')
//   def versions = version.split('\\.')
//   def major = versions[0]
//   def minor = versions[0] + '.' + versions[1]
//   def patch = version.trim()

def call(ImageVersion){
    echo "${ImageVersion}"
    def new_version = ''
    def version = ''
    def application = 'backend'	
    sh "curl -X GET -u '${NEXUS_USERNAME}':'${NEXUS_PASSWORD}' http://192.168.3.37:8081/repository/my-repo/VERSION -O"
		version = sh returnStdout: true, script: "cat VERSION | grep '${application}' | grep -Eo '[0-9]+(.[0-9]+)*'"		
		echo "$version"
 
		   if("${ImageVersion}"=="Patch"){
                      echo "This is patch version"
		      def versions = version.split('\\.')
		      def last = versions[2]
		      last = last.toInteger() + 1;
		      new_version = versions[0] + '.' + versions[1]+'.'+"$last"
		      echo "$new_version"
			echo "$version"	   
			
		      
		      }else if("${ImageVersion}"=="Minor"){
		      def versions = version.split('\\.')
		      def mid = versions[1]
		      mid = mid.toInteger() + 1;
		      new_version = versions[0] + '.' + "$mid"+'.'+0
		      echo "$new_version"
		     
		      
		      }else{
                      echo "This is major version"
		      def versions = version.split('\\.')
		      def first = versions[0]
		      first = first.toInteger() + 1;
		      new_version = "$first" + '.' + 0 +'.' + 0
		      echo "$new_version"
		    
		    }     
}
