package utilities;

import gov.tams.common.CommonProperties;
import org.apache.log4j.Logger;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.media.VideoFormatKeys;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author erlan.beisen
 * August, 10 2019
 * Creates a Video Record of executed Test
 */
final class TestVideoRecord {

    static ScreenRecorder screenRecorder;
    private static Logger logger;

    private TestVideoRecord () {}

    static { init(); }

    private static void init () {
        logger = logger == null ? Logger.getLogger(TestVideoRecord.class) : logger;
        screenRecorder = screenRecorder == null ? getScreenRecorder() : screenRecorder;
    }

    /**
     * @author erlan.beisen
     * @return Screen Recorder object
     */
    private static ScreenRecorder getScreenRecorder () {
        File scenarioRecordDirectory = scenarioRecordDirectory();
        GraphicsConfiguration gc = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration();

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        Rectangle captureSize = new Rectangle(0,0, width, height);
        ScreenRecorder screenRecorder = null;
        try {
            screenRecorder = new ScreenRecorder(gc, captureSize,
                    new Format(FormatKeys.MediaTypeKey, FormatKeys.MediaType.FILE, FormatKeys.MimeTypeKey, FormatKeys.MIME_AVI),
                    new Format(FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.EncodingKey, VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            VideoFormatKeys.CompressorNameKey, VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                            VideoFormatKeys.DepthKey, 24, FormatKeys.FrameRateKey, Rational.valueOf(15),
                            VideoFormatKeys.QualityKey, 1.0f,
                            FormatKeys.KeyFrameIntervalKey, 15 * 60),
                    new Format(FormatKeys.MediaTypeKey, FormatKeys.MediaType.VIDEO, FormatKeys.EncodingKey, "black",
                            FormatKeys.FrameRateKey, Rational.valueOf(30)),
                    null, scenarioRecordDirectory);
        } catch ( IOException | AWTException e ) {
            logger.error(e.getMessage());
        }
        return screenRecorder;
    }

    /**
     * @author erlan.beisen
     * @return Video Directory
     */
    private static File scenarioRecordDirectory () {
        String scenarioName = DataStore.getValueAsString("scenario name");
        File scenarioRecordDirectory = new File(CommonProperties.USER_DIR + "/reports/video/" + scenarioName);
        boolean isScenarioRecordDirectory = scenarioRecordDirectory.exists();
        if ( isScenarioRecordDirectory ) {
            File [] videoRecordFiles = scenarioRecordDirectory.listFiles();
            if ( videoRecordFiles != null && videoRecordFiles.length > 0 ) {
                boolean isVideoRecordFilesOverwrite = Boolean.parseBoolean(System.getenv("video_record_files_overwrite"));
                if ( isVideoRecordFilesOverwrite ) {
                    Arrays.stream(videoRecordFiles).forEachOrdered( file -> {
                        boolean isFileDelete = file.delete();
                        if ( isFileDelete ) logger.info("Video record file \"" + file.getName() + "\" deleted");
                    });
                }
            }
        }
        return scenarioRecordDirectory;
    }
}
