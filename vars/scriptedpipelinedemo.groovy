def call(Map pipelineparam)
{
env.REPO_NAME = pipelineparam.REPO_NAME
env.BRANCH = pipelineparam.BRANCH
pipeline
{
node
{
stage("code checkout")
{
sh '''
rm -rf CounterWebApp
git clone $REPO_NAME
cd CounterWebApp
git checkout $BRANCH
'''
}
stage
{
sh '''
cd CounterWebApp
mvn clean install
'''
}
}
}

}
