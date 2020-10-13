package com.grpc.server.greeting.service;

import com.grpc.server.greeting.generated.HelloRequest;
import com.grpc.server.greeting.generated.HelloResponse;
import com.grpc.server.greeting.generated.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String name = request.getName();

        HelloResponse response = HelloResponse.newBuilder().setGreeting("Hello, " + name + "!").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
