package com.amrut.kubernetes;

import io.fabric8.kubernetes.api.model.Pod;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.LocalPortForward;

import java.util.Map;

public class Fabic8Application {
    public static void main(String[] args) throws Exception {

        DefaultKubernetesClient client = new DefaultKubernetesClient();

        //case 1
        //Print all Namespace
        client.namespaces()
                .list().getItems()
                .stream()
                .map(namespace -> namespace.getMetadata().getName())
                .forEach(System.out::println);

        //case 2
        // Get pods behind a service
        Map<String, String> selector = client
                .services()
                .inNamespace("amrut")
                .withName("service-name")
                .get()
                .getSpec()
                .getSelector();


        Pod kubePod = client.inNamespace("amrut")
                .pods().withLabels(selector)
                .list()
                .getItems()
                .stream()
                .findAny()
                .orElseThrow(() -> new Exception("pod not found"));

        System.out.println(kubePod.getMetadata().getName());


        //case 3
        //Port forward configuration

        LocalPortForward local = client.pods()
                .inNamespace("Amrut")
                .withName(kubePod.getMetadata().getName())
                .portForward(2222);
        System.out.println("Address: " + local.getLocalAddress());
        System.out.println("Port: " + local.getLocalPort());

        local.close();
    }
}

