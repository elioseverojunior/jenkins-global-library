/**
 * Configure Git User in the Pipeline and
 * Show Git Config if toggle feature is enables.
 * @param gitConfigList false
 */
def call(Boolean gitConfigList = false) {
  try {
    sh '''
        git config push.default simple
        git config user.email "jenkins@jenkins"
        git config user.name "Jenkins"
    '''
    if(gitConfigList) {
      sh "git config --list"
    }
  } catch (Exception err) {
    println("Error happend: ${err}")
  }
}
