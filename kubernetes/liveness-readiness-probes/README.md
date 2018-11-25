# Difference between Liveness and Readiness probes

* Liveness probe: When this probe succeeds it marks the pod it marks it ready immediately to serve requests from the 
services. This is usually used to tell that the pod is live ie. it has got all the resources required and the pod is good 
for the application in it. 

However when liveness probe failure threshold is reached, the pod will be restarted.

* Readiness probe: When the pod starts, it may not necessarily be ready to serve request(e.g the application is still 
initializing and does nto require a restart) that's where the readiness probe comes into picture. 

When the readiness probe exceed the failure threshold, It will be marked `Not Ready` and `does not` trigger a restart.

* **Note**: Success threshold does not count initial delay(both liveness and readiness). Meaning e.g:
    
    successThreshold: 1
    
    initialDelaySeconds: 20
    
    periodSeconds: 10
    
    Means, your pod is marked ready only after 30 secs(if the probe is successful) and not 20 secs(your initial delay)
