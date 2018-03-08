package org.libdohj;

// import ch.qos.logback.classic.LoggerContext;
import org.bitcoinj.core.*;
import org.bitcoinj.core.listeners.NewBestBlockListener;
import org.bitcoinj.kits.WalletAppKit;
import org.libdohj.params.DogecoinMainNetParams;
import org.libdohj.params.DogecoinRegTestParams;
import org.libdohj.params.DogecoinTestNet3Params;
import org.slf4j.LoggerFactory;
import org.spongycastle.util.encoders.Hex;

import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;


/**
 * Created by oscar on 12/09/2017.
 */
public class DownloadRegtest {
    public static void main(String[] args) throws Exception {
//        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
//        lc.stop();
        NetworkParameters params = DogecoinRegTestParams.get();
        Context btcContext = new Context(params);
        WalletAppKit kit = new WalletAppKit(btcContext, new File("/Users/oscar/temp/libdohj-wallet-regtest/"), "doge");
        kit.setPeerNodes(new PeerAddress(params, InetAddress.getLocalHost(), 18444));
        kit.startAsync();
        Thread.sleep(2000);
        kit.chain().addNewBestBlockListener(new NewBestBlockListener() {
            @Override
            public void notifyNewBestBlock(StoredBlock storedBlock) throws VerificationException {
                byte[] block = storedBlock.getHeader().bitcoinSerialize();
                String block2 = Hex.toHexString(block);
                System.out.println(storedBlock.getHeight() + ":" + block2);
            }
        });
        kit.awaitRunning();
        //.awaitRunning();
    }


    public void stop() {
        //Context.propagate(btcContext);
        //kit.stopAsync().awaitTerminated();
    }


}