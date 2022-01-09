# Repo Description


These are some of the examples of my brain dump while working with kubernetes, exploring various aspects.
These examples are just as reference guide.


Useful kubernetes plugins in Intellij
---

I have been using the kubernetes plugin in intellij, which helps in a lot of the autocomplete features. 

Kubernetes Plugin: https://plugins.jetbrains.com/plugin/10485-kubernetes


Kubernetes topics
--
Top level directory contain sample deployment and sample pod descriptors.

* [ Services ](kubernetes/services)
* [ Liveness  and readiness probes ](kubernetes/liveness-readiness-probes/)
* [ Secrets](kubernetes/secrets)
* [ Init container & Pod lifecycle](kubernetes/pod-lifecycle)

Kind Cluster
---
start the multi-node kind kuberneted cluster with the following command.
```shell
kind create cluster --name cluster-1 --config kind-cluster-config.yaml
```

Delete kind cluster
---

```shell
kind delete cluster --name cluster-1
```