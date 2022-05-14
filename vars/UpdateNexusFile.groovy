def call(application,version,new_version){
  def app_ver = "${application}"+'='+"${version}".trim()
	def new_app_ver = "${application}"+'='+"${new_version}".trim()
  sh "sed -i 's/${app_ver}/${new_app_ver}/g' VERSION" 
  //sh "curl -v -u '${NEXUS_USERNAME}':'${NEXUS_PASSWORD}' --upload-file VERSION http://192.168.3.37:8081/repository/my-repo/"
}
