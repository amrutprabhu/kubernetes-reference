# Kubernetes init container and container lifecycle hooks.

# Init container

An init container is container that starts before the actual container starts. This container is used to perform 
some initialization steps such as may be mount a volume to it to do some initialization on the volume itself.

**Note** : This container has no access to actual main container of the pod and only after the init container finishes, 
the main container starts doing its work.

# Container lifecycle hooks

We have pod lifecycle hooks which can be used to run certain commands at `post start` of the container or `pre stop` 
of the container. The name itself tells you the meaning. 

You can perform currently two tasks using the hooks:
1) Execute command on the container.
2) Execute HTTP request by providing host (this can also be any kubernetes service), port and path. 

**Note**  
1. `postStart` hooks runs asynchronously with ENTRYPOINT command of the container, so there is no guarantee that the 
container is available to serve requests.
        e.g 
        
        lifecycle:
          postStart:
            httpGet:
              port: 80
              host: <same container service>
              path: /
        
    So in the above example hitting the same container service might fail.


2.  When `postStart` hook fails it leads to the pod getting killed.

3.  When the `preStop` hook fails it leaves the pod in a terminating state until the pod reaches default `terminationGracePeriodSeconds`.
 



