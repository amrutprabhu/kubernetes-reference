# Kubernetes Secrets

Contents of this folder include:
1) [Pod with secret volume](deployment-with-secret-volume.yml): In this case secret is  mounted as a volume. 
When the secret volume is mounted at say `/etc/credential`, then secrets will be available as a file at location 
`/etc/credential/<key>` (`<key>` is the key in the secret), and its corresponding value is in clear text inside the file.

2) [Secret as env varible](pod-with-secret-as-env-variable.yml) : You can directly inject secrets as an env variable, 
But I would not recommend this way. 
3) [Secret descriptor](secret.yml): Sample secret descriptor. 

#Usefull command

Secrets is base64 encoded in the secret descriptor. You can generate this via the following command

``echo "<secret value>" | base64`` 
