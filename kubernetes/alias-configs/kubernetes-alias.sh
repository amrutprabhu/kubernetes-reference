#!/usr/bin/env bash

function namespace() {
  kubectl config set-context $(kubectl config current-context) --namespace=$1
}