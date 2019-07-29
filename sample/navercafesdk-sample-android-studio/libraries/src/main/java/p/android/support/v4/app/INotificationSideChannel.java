/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /Users/user/Documents/dev/android/projects/oss/oss-android-sdk/libraries/src/main/aidl/android/plug/v4/app/INotificationSideChannel.aidl
 */
package p.android.support.v4.app;
/**
 * Interface used for delivering notifications via a side channel that bypasses
 * the NotificationManagerService.
 *
 * @hide
 */
public interface INotificationSideChannel extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements INotificationSideChannel
{
private static final java.lang.String DESCRIPTOR = "android.plug.v4.app.INotificationSideChannel";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an android.plug.v4.app.INotificationSideChannel interface,
 * generating a proxy if needed.
 */
public static INotificationSideChannel asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof INotificationSideChannel))) {
return ((INotificationSideChannel)iin);
}
return new INotificationSideChannel.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
java.lang.String descriptor = DESCRIPTOR;
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(descriptor);
return true;
}
case TRANSACTION_notify:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
android.app.Notification _arg3;
if ((0!=data.readInt())) {
_arg3 = android.app.Notification.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.notify(_arg0, _arg1, _arg2, _arg3);
return true;
}
case TRANSACTION_cancel:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
int _arg1;
_arg1 = data.readInt();
java.lang.String _arg2;
_arg2 = data.readString();
this.cancel(_arg0, _arg1, _arg2);
return true;
}
case TRANSACTION_cancelAll:
{
data.enforceInterface(descriptor);
java.lang.String _arg0;
_arg0 = data.readString();
this.cancelAll(_arg0);
return true;
}
default:
{
return super.onTransact(code, data, reply, flags);
}
}
}
private static class Proxy implements INotificationSideChannel
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
/**
     * Send an ambient notification to the service.
     */
@Override public void notify(java.lang.String packageName, int id, java.lang.String tag, android.app.Notification notification) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(id);
_data.writeString(tag);
if ((notification!=null)) {
_data.writeInt(1);
notification.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_notify, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Cancel an already-notified notification.
     */
@Override public void cancel(java.lang.String packageName, int id, java.lang.String tag) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
_data.writeInt(id);
_data.writeString(tag);
mRemote.transact(Stub.TRANSACTION_cancel, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
/**
     * Cancel all notifications for the given package.
     */
@Override public void cancelAll(java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_cancelAll, _data, null, android.os.IBinder.FLAG_ONEWAY);
}
finally {
_data.recycle();
}
}
}
static final int TRANSACTION_notify = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_cancel = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_cancelAll = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
}
/**
     * Send an ambient notification to the service.
     */
public void notify(java.lang.String packageName, int id, java.lang.String tag, android.app.Notification notification) throws android.os.RemoteException;
/**
     * Cancel an already-notified notification.
     */
public void cancel(java.lang.String packageName, int id, java.lang.String tag) throws android.os.RemoteException;
/**
     * Cancel all notifications for the given package.
     */
public void cancelAll(java.lang.String packageName) throws android.os.RemoteException;
}
