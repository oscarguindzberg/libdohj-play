package org.libdohj;

import org.bitcoinj.core.*;
import org.bitcoinj.core.listeners.NewBestBlockListener;
import org.bitcoinj.kits.WalletAppKit;
import org.libdohj.params.DogecoinMainNetParams;
import org.spongycastle.util.encoders.Hex;

import java.io.File;
import java.io.InputStream;


/**
 * Created by oscar on 12/09/2017.
 */
public class Play2 {
    public static void main(String[] args) throws Exception {
        long lastBlock = 0x1a13f47e;
        long firstBlock = 0x1e0ffff0;
        long maxTarget = 0x1e0fffff;
        System.out.println(Utils.decodeCompactBits(maxTarget).toString(16));
    }


}