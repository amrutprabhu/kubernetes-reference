# Kubernetes Services

Contents of this folder include:
1) [AWS load balancer service](aws-loadbalancer-service-descriptor.yml): Internet facing load balancer will be spun up on aws.
2) [Cluster IP service](service-cluster-ip.yml) : Service Within the cluster
2) [Node Port Service](service-node-port.yml): The service is available at the kubenetes worker nodes which is only allowed between port 30,000 to
32,400 something.