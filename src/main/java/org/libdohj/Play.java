package org.libdohj;

//import ch.qos.logback.classic.LoggerContext;
import org.bitcoinj.core.*;
import org.bitcoinj.core.listeners.NewBestBlockListener;
import org.bitcoinj.kits.WalletAppKit;
import org.libdohj.params.DogecoinMainNetParams;
import org.libdohj.params.DogecoinTestNet3Params;
import org.slf4j.ILoggerFactory;
import org.slf4j.LoggerFactory;
import org.spongycastle.util.encoders.Hex;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;


/**
 * Created by oscar on 12/09/2017.
 */
public class Play {
    public static void main(String[] args) throws Exception {
        //LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        //lc.stop();

        // ILoggerFactory lf = LoggerFactory.getILoggerFactory();
        // lf.getLogger("asdad").

        //NetworkParameters params = DogecoinTestNet3Params.get();
        NetworkParameters params = DogecoinMainNetParams.get();
        Context btcContext = new Context(params);
        //InputStream checkpoints = Play.class.getResourceAsStream("/org.dogecoin.test.checkpoints");
        InputStream checkpoints = Play.class.getResourceAsStream("/org.dogecoin.production.checkpoints");
        //WalletAppKit kit = new WalletAppKit(btcContext, new File("/Users/oscar/temp/libdohj-wallet-testnet/"), "doge");
        WalletAppKit kit = new WalletAppKit(btcContext, new File("/Users/oscar/temp/libdohj-wallet-mainnet/"), "doge");
        kit.setCheckpoints(checkpoints);
        //CheckpointManager.checkpoint(params, checkpoints, kit.store(), new Date().getTime());
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