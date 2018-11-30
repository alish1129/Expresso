
export interface Chart {
    change: number;
    changeOverTime: number;
    changePercent: number;
    close: number;
    date: string;
    high: number;
    label: string;
    low: number;
    open: number;
    unadjustedVolume: number;
    volume: number;
    vwap: number;
    marketAverage?: number;
}
