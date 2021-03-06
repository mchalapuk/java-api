package net.quedex.api.user;

public interface InternalTransferListener {

    void onInternalTransferExecuted(InternalTransferExecuted internalTransferExecuted);

    void onInternalTransferRejected(InternalTransferRejected internalTransferRejected);

    void onInternalTransferReceived(InternalTransferReceived internalTransferReceived);
}
