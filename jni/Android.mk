LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE:= libBasicUsageEnvironment
LOCAL_C_INCLUDES := $(KERNEL_HEADERS) $(LOCAL_PATH)/include $(LOCAL_PATH)/UsageEnvironment/include $(LOCAL_PATH)/groupsock/include $(LOCAL_PATH)/liveMedia $(LOCAL_PATH)/BasicUsageEnvironment/include
LOCAL_CFLAGS := -DSOCKLEN_T=socklen_t -D_LARGEFILE_SOURCE=1 -D_FILE_OFFSET_BITS=64 -Wall -DBSD=1 -DANDROID -llog

#LOCAL_CFLAGS := -fno-rtti -fno-exceptions

LOCAL_SRC_FILES := \
		BasicUsageEnvironment/BasicHashTable.cpp \
		BasicUsageEnvironment/BasicUsageEnvironment0.cpp \
		BasicUsageEnvironment/BasicTaskScheduler.cpp \
		BasicUsageEnvironment/BasicTaskScheduler0.cpp \
		BasicUsageEnvironment/BasicUsageEnvironment.cpp \
		BasicUsageEnvironment/DelayQueue.cpp

include $(BUILD_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE:= libUsageEnvironment

LOCAL_C_INCLUDES := $(KERNEL_HEADERS) $(LOCAL_PATH)/include $(LOCAL_PATH)/UsageEnvironment/include $(LOCAL_PATH)/groupsock/include $(LOCAL_PATH)/liveMedia $(LOCAL_PATH)/BasicUsageEnvironment/include
LOCAL_CFLAGS := -DSOCKLEN_T=socklen_t -D_LARGEFILE_SOURCE=1 -D_FILE_OFFSET_BITS=64 -Wall -DBSD=1 -DANDROID
#LOCAL_CFLAGS := -fno-rtti -fno-exceptions
LOCAL_SRC_FILES := \
		UsageEnvironment/UsageEnvironment.cpp \
		UsageEnvironment/HashTable.cpp \
		UsageEnvironment/strDup.cpp 
include $(BUILD_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE:= libgroupsock
LOCAL_C_INCLUDES := $(KERNEL_HEADERS) $(LOCAL_PATH)/include $(LOCAL_PATH)/UsageEnvironment/include $(LOCAL_PATH)/groupsock/include $(LOCAL_PATH)/liveMedia $(LOCAL_PATH)/BasicUsageEnvironment/include
LOCAL_CFLAGS := -DSOCKLEN_T=socklen_t -D_LARGEFILE_SOURCE=1 -D_FILE_OFFSET_BITS=64 -Wall -DBSD=1  -DNO_SSTREAM -DANDROID
	
LOCAL_SRC_FILES := \
		groupsock/IOHandlers.cpp \
		groupsock/NetAddress.cpp \
		groupsock/Groupsock.cpp \
		groupsock/GroupsockHelper.cpp \
		groupsock/GroupEId.cpp \
		groupsock/NetInterface.cpp \
		groupsock/inet.c
include $(BUILD_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE:= libliveMedia
LOCAL_C_INCLUDES := $(KERNEL_HEADERS) $(LOCAL_PATH)/include $(LOCAL_PATH)/UsageEnvironment/include $(LOCAL_PATH)/groupsock/include $(LOCAL_PATH)/liveMedia $(LOCAL_PATH)/BasicUsageEnvironment/include $(LOCAL_PATH)/liveMedia/include
LOCAL_CFLAGS :=  -DSOCKLEN_T=socklen_t -fexceptions -DDEBUG -DLOCALE_NOT_USED -D_LARGEFILE_SOURCE=1 -D_FILE_OFFSET_BITS=64 -Wall -DBSD=1 -DANDROID  

LOCAL_SRC_FILES := \
		liveMedia/AC3AudioFileServerMediaSubsession.cpp  \
		liveMedia/AC3AudioRTPSink.cpp  \
		liveMedia/AC3AudioRTPSource.cpp  \
		liveMedia/AC3AudioStreamFramer.cpp  \
		liveMedia/ADTSAudioFileServerMediaSubsession.cpp  \
		liveMedia/ADTSAudioFileSource.cpp  \
		liveMedia/AMRAudioFileServerMediaSubsession.cpp  \
		liveMedia/AMRAudioFileSink.cpp  \
		liveMedia/AMRAudioFileSource.cpp  \
		liveMedia/AMRAudioRTPSink.cpp  \
		liveMedia/AMRAudioRTPSource.cpp  \
		liveMedia/AMRAudioSource.cpp  \
		liveMedia/AudioInputDevice.cpp  \
		liveMedia/AudioRTPSink.cpp  \
		liveMedia/AVIFileSink.cpp  \
		liveMedia/Base64.cpp  \
		liveMedia/BasicUDPSink.cpp  \
		liveMedia/BasicUDPSource.cpp  \
		liveMedia/BitVector.cpp  \
		liveMedia/ByteStreamFileSource.cpp  \
		liveMedia/ByteStreamMemoryBufferSource.cpp  \
		liveMedia/ByteStreamMultiFileSource.cpp  \
		liveMedia/DeviceSource.cpp  \
		liveMedia/DigestAuthentication.cpp  \
		liveMedia/DVVideoFileServerMediaSubsession.cpp  \
		liveMedia/DVVideoRTPSink.cpp  \
		liveMedia/DVVideoRTPSource.cpp  \
		liveMedia/DVVideoStreamFramer.cpp  \
		liveMedia/EBMLNumber.cpp  \
		liveMedia/FileServerMediaSubsession.cpp  \
		liveMedia/FileSink.cpp  \
		liveMedia/FramedFileSource.cpp  \
		liveMedia/FramedFilter.cpp  \
		liveMedia/FramedSource.cpp  \
		liveMedia/GenericMediaServer.cpp  \
		liveMedia/GSMAudioRTPSink.cpp  \
		liveMedia/H261VideoRTPSource.cpp  \
		liveMedia/H263plusVideoFileServerMediaSubsession.cpp  \
		liveMedia/H263plusVideoRTPSink.cpp  \
		liveMedia/H263plusVideoRTPSource.cpp  \
		liveMedia/H263plusVideoStreamFramer.cpp  \
		liveMedia/H263plusVideoStreamParser.cpp  \
		liveMedia/H264or5VideoFileSink.cpp  \
		liveMedia/H264or5VideoRTPSink.cpp  \
		liveMedia/H264or5VideoStreamDiscreteFramer.cpp  \
		liveMedia/H264or5VideoStreamFramer.cpp  \
		liveMedia/H264VideoFileServerMediaSubsession.cpp  \
		liveMedia/H264VideoFileSink.cpp  \
		liveMedia/H264VideoRTPSink.cpp  \
		liveMedia/H264VideoRTPSource.cpp  \
		liveMedia/H264VideoStreamDiscreteFramer.cpp  \
		liveMedia/H264VideoStreamFramer.cpp  \
		liveMedia/H265VideoFileServerMediaSubsession.cpp  \
		liveMedia/H265VideoFileSink.cpp  \
		liveMedia/H265VideoRTPSink.cpp  \
		liveMedia/H265VideoRTPSource.cpp  \
		liveMedia/H265VideoStreamDiscreteFramer.cpp  \
		liveMedia/H265VideoStreamFramer.cpp  \
		liveMedia/InputFile.cpp  \
		liveMedia/JPEGVideoRTPSink.cpp  \
		liveMedia/JPEGVideoRTPSource.cpp  \
		liveMedia/JPEGVideoSource.cpp  \
		liveMedia/Locale.cpp  \
		liveMedia/MatroskaDemuxedTrack.cpp  \
		liveMedia/MatroskaFile.cpp  \
		liveMedia/MatroskaFileParser.cpp  \
		liveMedia/MatroskaFileServerDemux.cpp  \
		liveMedia/MatroskaFileServerMediaSubsession.cpp  \
		liveMedia/Media.cpp  \
		liveMedia/MediaSession.cpp  \
		liveMedia/MediaSink.cpp  \
		liveMedia/MediaSource.cpp  \
		liveMedia/MP3ADU.cpp  \
		liveMedia/MP3ADUdescriptor.cpp  \
		liveMedia/MP3ADUinterleaving.cpp  \
		liveMedia/MP3ADURTPSink.cpp  \
		liveMedia/MP3ADURTPSource.cpp  \
		liveMedia/MP3ADUTranscoder.cpp  \
		liveMedia/MP3AudioFileServerMediaSubsession.cpp  \
		liveMedia/MP3AudioMatroskaFileServerMediaSubsession.cpp  \
		liveMedia/MP3FileSource.cpp  \
		liveMedia/MP3Internals.cpp  \
		liveMedia/MP3InternalsHuffman.cpp  \
		liveMedia/MP3InternalsHuffmanTable.cpp  \
		liveMedia/MP3StreamState.cpp  \
		liveMedia/MP3Transcoder.cpp  \
		liveMedia/MPEG1or2AudioRTPSink.cpp  \
		liveMedia/MPEG1or2AudioRTPSource.cpp  \
		liveMedia/MPEG1or2AudioStreamFramer.cpp  \
		liveMedia/MPEG1or2Demux.cpp  \
		liveMedia/MPEG1or2DemuxedElementaryStream.cpp  \
		liveMedia/MPEG1or2DemuxedServerMediaSubsession.cpp  \
		liveMedia/MPEG1or2FileServerDemux.cpp  \
		liveMedia/MPEG1or2VideoFileServerMediaSubsession.cpp  \
		liveMedia/MPEG1or2VideoRTPSink.cpp  \
		liveMedia/MPEG1or2VideoRTPSource.cpp  \
		liveMedia/MPEG1or2VideoStreamDiscreteFramer.cpp  \
		liveMedia/MPEG1or2VideoStreamFramer.cpp  \
		liveMedia/MPEG2IndexFromTransportStream.cpp  \
		liveMedia/MPEG2TransportFileServerMediaSubsession.cpp  \
		liveMedia/MPEG2TransportStreamFramer.cpp  \
		liveMedia/MPEG2TransportStreamFromESSource.cpp  \
		liveMedia/MPEG2TransportStreamFromPESSource.cpp  \
		liveMedia/MPEG2TransportStreamIndexFile.cpp  \
		liveMedia/MPEG2TransportStreamMultiplexor.cpp  \
		liveMedia/MPEG2TransportStreamTrickModeFilter.cpp  \
		liveMedia/MPEG2TransportUDPServerMediaSubsession.cpp  \
		liveMedia/MPEG4ESVideoRTPSink.cpp  \
		liveMedia/MPEG4ESVideoRTPSource.cpp  \
		liveMedia/MPEG4GenericRTPSink.cpp  \
		liveMedia/MPEG4GenericRTPSource.cpp  \
		liveMedia/MPEG4LATMAudioRTPSink.cpp  \
		liveMedia/MPEG4LATMAudioRTPSource.cpp  \
		liveMedia/MPEG4VideoFileServerMediaSubsession.cpp  \
		liveMedia/MPEG4VideoStreamDiscreteFramer.cpp  \
		liveMedia/MPEG4VideoStreamFramer.cpp  \
		liveMedia/MPEGVideoStreamFramer.cpp  \
		liveMedia/MPEGVideoStreamParser.cpp  \
		liveMedia/MultiFramedRTPSink.cpp  \
		liveMedia/MultiFramedRTPSource.cpp  \
		liveMedia/OggDemuxedTrack.cpp  \
		liveMedia/OggFile.cpp  \
		liveMedia/OggFileParser.cpp  \
		liveMedia/OggFileServerDemux.cpp  \
		liveMedia/OggFileServerMediaSubsession.cpp  \
		liveMedia/OggFileSink.cpp  \
		liveMedia/OnDemandServerMediaSubsession.cpp  \
		liveMedia/ourMD5.cpp  \
		liveMedia/OutputFile.cpp  \
		liveMedia/PassiveServerMediaSubsession.cpp  \
		liveMedia/ProxyServerMediaSession.cpp  \
		liveMedia/QCELPAudioRTPSource.cpp  \
		liveMedia/QuickTimeFileSink.cpp  \
		liveMedia/QuickTimeGenericRTPSource.cpp  \
		liveMedia/RTCP.cpp  \
		liveMedia/rtcp_from_spec.c \
		liveMedia/RTPInterface.cpp  \
		liveMedia/RTPSink.cpp  \
		liveMedia/RTPSource.cpp  \
		liveMedia/RTSPClient.cpp  \
		liveMedia/RTSPCommon.cpp  \
		liveMedia/RTSPRegisterSender.cpp  \
		liveMedia/RTSPServer.cpp  \
		liveMedia/RTSPServerSupportingHTTPStreaming.cpp  \
		liveMedia/ServerMediaSession.cpp  \
		liveMedia/SimpleRTPSink.cpp  \
		liveMedia/SimpleRTPSource.cpp  \
		liveMedia/SIPClient.cpp  \
		liveMedia/StreamParser.cpp  \
		liveMedia/StreamReplicator.cpp  \
		liveMedia/T140TextRTPSink.cpp  \
		liveMedia/TCPStreamSink.cpp  \
		liveMedia/TextRTPSink.cpp  \
		liveMedia/TheoraVideoRTPSink.cpp  \
		liveMedia/TheoraVideoRTPSource.cpp  \
		liveMedia/uLawAudioFilter.cpp  \
		liveMedia/VideoRTPSink.cpp  \
		liveMedia/VorbisAudioRTPSink.cpp  \
		liveMedia/VorbisAudioRTPSource.cpp  \
		liveMedia/VP8VideoRTPSink.cpp  \
		liveMedia/VP8VideoRTPSource.cpp  \
		liveMedia/VP9VideoRTPSink.cpp  \
		liveMedia/VP9VideoRTPSource.cpp  \
		liveMedia/WAVAudioFileServerMediaSubsession.cpp  \
		liveMedia/WAVAudioFileSource.cpp
include $(BUILD_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libavcodec
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libavcodec.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libavdevice
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libavdevice.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libavfilter
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libavfilter.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libavformat
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libavformat.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libavutil
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libavutil.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libpostproc
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libpostproc.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libswresample
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libswresample.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libswscale
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libswscale.a
include $(PREBUILT_STATIC_LIBRARY)


include $(CLEAR_VARS)
LOCAL_MODULE    := libx264
LOCAL_SRC_FILES := ffmpeg/android/armv7-a/lib/libx264.a
include $(PREBUILT_STATIC_LIBRARY)


# ***** streamer *****
include $(CLEAR_VARS)
LOCAL_MODULE := videoplus

LOCAL_C_INCLUDES := $(LOCAL_PATH)/UsageEnvironment/include \
	$(LOCAL_PATH)/groupsock/include \
	$(LOCAL_PATH)/liveMedia \
	$(LOCAL_PATH)/BasicUsageEnvironment/include \
	$(LOCAL_PATH)/liveMedia/include  \
	$(LOCAL_PATH)/VideoPlus/jni-include  \
	$(LOCAL_PATH)/VideoPlus/include  \
	$(LOCAL_PATH)/ffmpeg/android/armv7-a/include

LOCAL_CFLAGS := -march=armv7-a -mfloat-abi=softfp -mfpu=neon
LOCAL_CFLAGS += -DSOCKLEN_T=socklen_t -D_LARGEFILE_SOURCE=1 -D_FILE_OFFSET_BITS=64 -Wall -DBSD=1 -DANDROID -llog
LOCAL_LDFLAGS += -Wl,--export-dynamic

LOCAL_SRC_FILES := \
		VideoPlus/src/com_xproject_videoplus_Streamer.cpp \
		VideoPlus/src/H264LiveCapture.c \
		VideoPlus/src/H264LiveFramedSource.cpp \
		VideoPlus/src/H264LiveCaptureThread.cpp \
		VideoPlus/src/H264LiveServerMediaSubsession.cpp
		
LOCAL_LDLIBS += -llog -ldl -lz -lm

LOCAL_STATIC_LIBRARIES := \
		libavformat \
		libavdevice \
		libavcodec \
		libavutil \
		libavfilter \
		libpostproc \
		libswresample \
		libswscale \
		libx264 \
		libliveMedia \
		libgroupsock \
		libBasicUsageEnvironment \
		libUsageEnvironment \
    
include $(BUILD_SHARED_LIBRARY)